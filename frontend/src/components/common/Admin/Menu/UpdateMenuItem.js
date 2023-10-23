import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';

function UpdateMenuItem() {
  const { menuId, itemId } = useParams(); // Extract menu and item IDs from the URL
  const navigate = useNavigate();

  const [menuItem, setMenuItem] = useState({
    name: '',
    description: '',
    price: 0,
  });

  useEffect(() => {
    const fetchMenuItemDetails = async () => {
      try {
        const response = await axios.get(`http://localhost:8088/api/menu/menuitems/${itemId}`);
        setMenuItem(response.data);
      } catch (error) {
        console.error(`Error fetching menu item details for ID ${itemId}:`, error);
      }
    };

    fetchMenuItemDetails();
  }, [itemId]);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setMenuItem({
      ...menuItem,
      [name]: value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.put(`http://localhost:8088/api/menu/menuitems/${itemId}`, menuItem)
      .then((response) => {
        console.log('Menu item updated:', response.data);
        navigate(`/admin/menu/update/${menuId}`); // Navigate back to the menu item list
      })
      .catch((error) => {
        console.error(`Error updating menu item with ID ${itemId}:`, error);
      });
  };

  return (
    <div className="container mt-4 col-8">
      <h2 style={{ fontSize: '24px', color: 'black', paddingBottom: '10px' }}>Update Menu Item:</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="name" style={{ fontSize: '15px', color: 'black' }}>Name:</label>
          <input
            type="text"
            id="name"
            name="name"
            value={menuItem.name}
            onChange={handleInputChange}
            style={{ fontSize: '14px', color: 'black', padding: '5px' }}
            className="form-control my-2"
          />
        </div>
        <div className="form-group my-2">
          <label htmlFor="description" style={{ fontSize: '15px', color: 'black' }}>Description:</label>
          <textarea
            id="description"
            name="description"
            value={menuItem.description}
            onChange={handleInputChange}
            style={{ fontSize: '14px', color: 'black', padding: '5px' }}
            className="form-control my-2"
          />
        </div>
        <div className="form-group my-2">
          <label htmlFor="price" style={{ fontSize: '15px', color: 'black' }}>Price:</label>
          <input
            type="number"
            id="price"
            name="price"
            value={menuItem.price}
            onChange={handleInputChange}
            style={{ fontSize: '14px', color: 'black', padding: '5px' }}
            className="form-control my-2"
          />
        </div>
        <div>
          <button type="submit" className="btn btn-primary my-2">Update Menu Item</button>
        </div>
      </form>
    </div>
  );
}

export default UpdateMenuItem;
