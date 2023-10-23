import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom'; // Assuming you are using React Router for navigation

function AddMenuForm() {
  const [menu, setMenu] = useState({
    name: '',
    description: '',
  });

  const [menus, setMenus] = useState([]);
  const [menuItems, setMenuItems] = useState({});

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setMenu({
      ...menu,
      [name]: value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post('http://localhost:8088/api/menu/menu', menu)
      .then((response) => {
        console.log('Menu added:', response.data);
        setMenu({
          name: '',
          description: '',
        });
        fetchMenus();
      })
      .catch((error) => {
        console.error('Error adding menu:', error);
      });
  };

  const fetchMenus = () => {
    axios.get('http://localhost:8088/api/menu/menu')
      .then((response) => {
        setMenus(response.data);
      })
      .catch((error) => {
        console.error('Error fetching menus:', error);
      });
  };

  useEffect(() => {
    fetchMenus();
  }, []);

  const fetchMenuItems = async (menuId) => {
    try {
      const response = await axios.get(`http://localhost:8088/api/menu/menu/${menuId}/menu-items`);
      return response.data;
    } catch (error) {
      console.error(`Error fetching menu items for menu ${menuId}:`, error);
      return [];
    }
  };

  useEffect(() => {
    menus.forEach(async (menu) => {
      const items = await fetchMenuItems(menu.id);
      setMenuItems((prevMenuItems) => ({
        ...prevMenuItems,
        [menu.id]: items,
      }));
    });
  }, [menus]);

  const handleDeleteMenu = (menuId) => {
    axios.delete(`http://localhost:8088/api/menu/menu/${menuId}`)
      .then(() => {
        console.log(`Menu with ID ${menuId} deleted.`);
        fetchMenus();
      })
      .catch((error) => {
        console.error(`Error deleting menu with ID ${menuId}:`, error);
      });
  };

  return (
    <div className="container mt-4 col-8">
      <h2 style={{ fontSize: '40px', color: 'black', padding: '10px' }}>Add Menu :</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="name" style={{ fontSize: '15px', color: 'black' }}>Name:</label>
          <input
            type="text"
            id="name"
            name="name"
            value={menu.name}
            onChange={handleInputChange}
            style={{ fontSize: '15px', color: 'black', padding: '5px' }}
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
            style={{ fontSize: '15px', color: 'black', padding: '5px' }}
            className="form-control my-2"
          />
        </div>
        <div>
          <button type="submit" className="btn btn-primary my-2 mb-5">Add Menu</button>
        </div>
      </form>

      <hr className="my-4" />

      <h2 style={{ fontSize: '40px', color: 'black', padding: '10px' }}>Menu List :</h2>
      <table className="table my-4">
        <thead>
          <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Menu Items</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {menus.map((menu) => (
            <tr key={menu.id}>
              <td>{menu.name}</td>
              <td>{menu.description}</td>
              <td>
                <ul>
                  {menuItems[menu.id] &&
                    menuItems[menu.id].map((item) => (
                      <li key={item.id}>{item.name}</li>
                    ))}
                </ul>
              </td>
              <td>
                <Link to={`update-menu/${menu.id}`} className="btn btn-primary me-2">
                  Update
                </Link>
                <button
                  className="btn btn-danger"
                  onClick={() => handleDeleteMenu(menu.id)}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default AddMenuForm;
