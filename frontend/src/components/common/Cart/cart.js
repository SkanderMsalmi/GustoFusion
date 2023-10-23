import React, { useContext, useEffect, useState } from 'react';

import axios from 'axios';

const Cart = () => {
//   const { cart, addItem, removeItem, clearCart } = useContext(CartContext);
  const [cartItems, setCartItems] = useState([]);

  // Fetch cart items from the API when the component mounts
  useEffect(() => {
    axios.get('http://localhost:8085/api/livraison/cart/cartItems') // Replace with your API endpoint
      .then((response) => {
        setCartItems(response.data);
        console.log('Cart Items:', response.data); // Log the cartItems
      })
      .catch((error) => {
        console.error('Error fetching cart items:', error);
      });
  }, []);
  const myList = cartItems.map((item) => {
    
    
    return<tr>
    <th scope="row">1</th>
    <td>{item.menuItem.description}</td>
    <td>{item.menuItem.name}</td>
    <td>{item.quantity}</td>
  </tr>

})

let obj = [
  {
      name:"Email",
      type:"email",
      typeShow:1,
      formAttr:"customerEmail",
  },
  {
      name:"Phone",
      type:"number",
      typeShow:1,
      formAttr:"customerPhone",
  },

  {
    name:"State",
    type:"text",
    typeShow:1,
    formAttr:"deliveryState",
},
  {
      name:"City",
      type:"text",
      typeShow:1,
      formAttr:"deliveryCity",
  },
  {
      name:"Postal Code",
      type:"text",
      typeShow:1,
      formAttr:"deliveryPostalCode",
  },


  // {
  //     name:"Payment Methode",
  //     type:"text",
  //     type:1,
  // },
  {
      name:"Address",
      type:"text",
      typeShow:2,
      formAttr:"deliveryStreetAddress",
  },
  {
      name:"Instructions",
      type:"text",
      typeShow:2,
      formAttr:"deliveryInstructions",
  },

]

const [postForm , setPostForm]=useState({
  customerEmail: "",
  customerPhone: "",
  deliveryStreetAddress: "",
  deliveryCity: "",
  deliveryState: "",
  deliveryPostalCode: "",
  deliveryInstructions: "",

})

const [openDialog , setOpenDialog]= useState(false); 
function handleOrder(){


  console.log(postForm)
  
  axios.post('http://localhost:8085/api/livraison/orders?cartId='+4,{ "orderDateTime": "2023-10-19T14:30:00",
  "orderStatus": "ready",
 
  ...postForm,
  "orderTotalAmount": 50.00,
  "paymentStatus": "Paid",
  "paymentMethod": "Credit Card"}) // Replace with your API endpoint
      .then((response) => {
       
        console.log('alert'); // Log the cartItems
      })
      .catch((error) => {
        console.error('Error fetching cart items:', error);
      });
}
function openDialogEvent(e) {
  e.preventDefault();
  setOpenDialog(!openDialog)
}

  return (
    <section className='book-a-table main-div'>
        <div class="tableCart-container">
    <table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Description</th>
      <th scope="col">Quantity</th>
    </tr>
  </thead>
  <tbody>
    {myList}
   
  </tbody>
</table>
<button  onClick={openDialogEvent} class="golden-button">Proceed to order</button>
</div>

{
  openDialog ? 


<div className="dialogHolder" >
            <div className="dialog">
                <div className="orderHolder">

                    <div className="topHeader">
                        <div className="title">
                              Order
                        </div>

                        <div className="singleItem" onClick={openDialogEvent} >
                            <i className="bi bi-x" />
                           
                        </div>
                    </div>
                    <div className="orderForm">
                        <div>
                            <div className="container">
                            <div class="row">

                        {
                            obj.map((item , index)=>{
                                if(item.typeShow==1)
                                return (
                                    <div key={index} class="col-md-6">
                            <input value={postForm[item.formAttr]} onChange={(e)=> setPostForm({...postForm , [item.formAttr]:   e.target.value})} type={item.type} class="form-control inputStyle" placeholder={item.name}></input>
                            </div>
                                )
                                else {
                                    return(
                                        <div key={index} class="col-md-12">
                                            <textarea  onChange={(e)=> setPostForm({...postForm , [item.formAttr]:   e.target.value})}  class="form-control inputStyle" placeholder={item.name}>
                                           {postForm[item.formAttr]} 
                                            </textarea>
                                        
                                        </div>

                                    )
                                }
                            })
                        }


                        {/*     
                            <div class="col-md-6">
                            <input type="text" class="form-control" placeholder="Last name"></input>
                            </div>
                            <div class="col-md-6">
                            <input type="text" class="form-control" placeholder="Last name"></input>
                            </div>
                            <div class="col-md-6">
                            <input type="text" class="form-control" placeholder="Last name"></input>
                            </div> */}

                            
                        </div>
                            </div>
                        <div className="btnHolder">
                             <button class="submitButton" onClick={handleOrder}>checkout</button>
                        </div>
                       
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
      : null
      }
</section>
   
  );
};

export default Cart;