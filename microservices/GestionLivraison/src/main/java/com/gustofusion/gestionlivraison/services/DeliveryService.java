package com.gustofusion.gestionlivraison.services;

import com.gustofusion.gestionemploye.entities.Livreur;
import com.gustofusion.gestionemploye.repositories.LivreurRepository;
import com.gustofusion.gestionlivraison.entities.Delivery;
import com.gustofusion.gestionlivraison.entities.Order;
import com.gustofusion.gestionlivraison.repositories.DeliveryRepository;
import com.gustofusion.gestionlivraison.repositories.OrderRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.apache.commons.lang.RandomStringUtils;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService implements DeliveryServiceInterface {
    @Autowired
    private DeliveryRepository deliveryRepository;
    @Autowired
    private LivreurRepository livreurRepository;
    @Autowired
    private OrderRepository orderRepository;

    public void sendConfirmationCode(Long orderId,String confirmationCode){
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with ID: " + orderId));
        long delId=order.getDelivery().getId();
        Delivery delivery = deliveryRepository.findById(delId).orElseThrow(() -> new EntityNotFoundException("Delivery not found with ID: " + delId));;
         long driverId=delivery.getDriver().getId();
                // Twilio.init(System.getenv("ACf6ca18796a5cf6359536ab7a55a516ac"), System.getenv("1708fcc0add1c2d5866bbe99655a355e"));
                String smsBody = "Hello , your delivery is on the way, here's your order Id:"+orderId +"\nand the driver ID to submit you feed back:"+driverId+"here is your confirmation code please provide it to the driver to confirm your delivery :"+confirmationCode;
                Twilio.init("ACbe95647bac01abcb809623c19bdd3d9f", "11ece026195b73cfd43730f5d72bd4d8");
                Message.creator(new PhoneNumber("+216"+order.getCustomerPhone()),
                        new PhoneNumber("+18456320970"), smsBody).create();

    }
    private Delivery actualDelivery;
    public Delivery createDelivery(Long orderId, int driverId, Delivery delivery) {
        // Retrieve the order by orderId
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with ID: " + orderId));

        // Retrieve the driver by driverId
        Livreur driver = livreurRepository.findById(driverId)
                .orElseThrow(() -> new EntityNotFoundException("Driver not found with ID: " + driverId));

        // Set the order and driver for the delivery
        delivery.setOrders(Collections.singletonList(order));
        delivery.setDriver(driver);
        delivery.setOrderId(orderId);

        String confirmationCode = RandomStringUtils.randomAlphanumeric(8);
        delivery.setDeliveryConfirmationCode(confirmationCode);
        //sendConfirmationCode(orderId,confirmationCode);
        actualDelivery=delivery;
        // Save the delivery
        order.setDelivery(delivery);
        orderRepository.save(order);


        return deliveryRepository.save(delivery);
    }


    public void confirmDelivery(Long orderId, String providedConfirmationCode) {
        // Find the delivery by its ID
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("order not found"));
        Delivery delivery = deliveryRepository.findById(order.getDelivery().getId())
                .orElseThrow(() -> new EntityNotFoundException("Delivery not found"));

        // Check if the provided code matches the saved code
        if (providedConfirmationCode.equals(delivery.getDeliveryConfirmationCode())) {
            // If the codes match, set the delivery status to "Confirmed"
            delivery.setDeliveryStatus("Confirmed");

            // Save the updated delivery
            deliveryRepository.save(delivery);
        } else {
            // Handle invalid confirmation code (e.g., throw an exception or log a message)
        }
    }

    @Transactional
    public Delivery updateDelivery(Long orderId, int driverId, String customerFeedback, int customerRating, Date actualDeliveryTime) {
        // Retrieve the order by orderId
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with ID: " + orderId));

        // Retrieve the driver by driverId
        Livreur driver = livreurRepository.findById(driverId)
                .orElseThrow(() -> new EntityNotFoundException("Driver not found with ID: " + driverId));

        // Find the delivery related to the order and driver
        Delivery delivery = deliveryRepository.findByOrderIdAndDriver(orderId, driver);

        if (delivery != null) {
            // Update the delivery attributes
            delivery.setCustomerFeedback(customerFeedback);
            delivery.setCustomerRating(customerRating);
            delivery.setActualDeliveryTime(actualDeliveryTime);

            // Save the updated delivery
            return deliveryRepository.save(delivery);
        } else {
            // Handle the case when no related delivery is found (optional).
            throw new EntityNotFoundException("Delivery not found for Order ID: " + orderId + " and Driver ID: " + driverId);
        }
    }

}
