import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link, useParams } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';

function UpdateMenu() {
  const { menuId } = useParams();
  const navigate = useNavigate();

  const [menu, setMenu] = useState({
    name: '',
    description: '',
  });
  const [menuItems, setMenuItems] = useState([]);
  const [newMenuItem, setNewMenuItem] = useState({
    name: '',
    description: '',
    price: 0,
  });

  const fetchMenuDetails = () => {
    axios.get(`http://localhost:8088/api/menu/menu/${menuId}`)
      .then((response) => {
        setMenu(response.data);
      })
      .catch((error) => {
        console.error(`Error fetching menu details for menu ${menuId}:`, error);
      });
  };

  const fetchMenuItems = () => {
    axios.get(`http://localhost:8088/api/menu/menuitems`)
      .then((response) => {
        setMenuItems(response.data);
      })
      .catch((error) => {
        console.error(`Error fetching menu items for menu ${menuId}:`, error);
      });
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setMenu({
      ...menu,
      [name]: value,
    });
  };

  const handleNewMenuItemChange = (e) => {
    const { name, value } = e.target;
    setNewMenuItem({
      ...newMenuItem,
      [name]: value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.put(`http://localhost:8088/api/menu/menu/${menuId}`, menu)
      .then((response) => {
        console.log('Menu updated:', response.data);
        fetchMenuDetails();
        navigate('/admin/menu');
      })
      .catch((error) => {
        console.error(`Error updating menu with ID ${menuId}:`, error);
      });
  };

  const handleDeleteMenuItem = (menuItemId) => {
    axios.delete(`http://localhost:8088/api/menu/menuitems/${menuItemId}`)
      .then(() => {
        console.log(`Menu item with ID ${menuItemId} deleted.`);
        fetchMenuItems();
      })
      .catch((error) => {
        console.error(`Error deleting menu item with ID ${menuItemId}:`, error);
      });
  };

  const handleAddMenuItem = () => {
    axios.post(`http://localhost:8088/api/menu/menuitems`, newMenuItem)
      .then((response) => {
        console.log('Menu item added:', response.data);
        setNewMenuItem({
            name: '',
            description: '',
            price: '',
          });
        fetchMenuItems();
          })
      .catch((error) => {
        console.error('Error adding menu item:', error);
      });
  };

  useEffect(() => {
    fetchMenuDetails();
    fetchMenuItems();
  }, [menuId]);

  return (
    <div className="container mt-4 col-9">
      <h2 style={{ fontSize: '24px', color: 'black', paddingBottom: '10px' }}>Update Menu:</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="name" style={{ fontSize: '15px', color: 'black' }}>Name:</label>
          <input
            type="text"
            id="name"
            name="name"
            value={menu.name}
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
            value={menu.description}
            onChange={handleInputChange}
            style={{ fontSize: '14px', color: 'black', padding: '5px' }}
            className="form-control my-2"
          />
        </div>
        <div>
          <button type="submit" className="btn btn-primary my-2">Update Menu</button>
        </div>
      </form>
      <hr className="my-4" />

      <h2 style={{ fontSize: '24px', color: 'black', paddingBottom: '10px' }}>Menu Items:</h2>
      <table className="table table-striped">
        <thead>
          <tr>
            <th>Name</th>
            <th>description</th>
            <th>price</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {menuItems.map((menuItem) => (
            <tr key={menuItem.id}>
              <td>{menuItem.name}</td>
              <td>{menuItem.description}</td>
              <td>{menuItem.price}</td>
              <td>
                <button
                  onClick={() => handleDeleteMenuItem(menuItem.id)}
                  className="btn btn-danger btn-sm mx-3"
                >
                  Delete
                </button>
                <Link
                  to={`${menuId}/items/update/${menuItem.id}`}
                  className="btn btn-primary btn-sm ml-2"
                >
                  Update
                </Link>
              </td>
            </tr>
          ))}
          <tr>
            <td>
              <input
                type="text"
                name="name"
                value={newMenuItem.name}
                onChange={handleNewMenuItemChange}
              />
            </td>
            <td>
              <input
                type="text"
                name="description"
                value={newMenuItem.description}
                onChange={handleNewMenuItemChange}
              />
            </td>
            <td>
              <input
                type="number"
                name="price"
                value={newMenuItem.price}
                onChange={handleNewMenuItemChange}
              />
            </td>
            <td>
              <button onClick={handleAddMenuItem}>Add Menu Item</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}

export default UpdateMenu;
