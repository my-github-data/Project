import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './PackageBody.css';
import south from './images/south.jpg';
import punetrek from './images/punetrek.jpg';
import backpack from './images/backpack.jpg';
import camping from './images/camping.jpg';
import flower from './images/flower.jpg';
import { Link } from 'react-router-dom';

function PackageBodyM() {
  const [packages, setPackages] = useState([]);

  useEffect(() => {
    async function fetchData() {
      try {
        const packageResponses = await Promise.all(
          Array.from({ length: 5 }, (_, index) =>
            axios.get(`http://localhost:8080/package/viewPackage/${index + 6}`)
          )
        );
        const packagesData = packageResponses.map(response => response.data);
        setPackages(packagesData);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    }

    fetchData();
  }, []);

  // Define static images for each package
  const packageImages = [south, punetrek, backpack, camping, flower];

  return (
    <div className="container-fluid">
      {packages.map((packageData, index) => (
        <div className="row" key={index}>
          <div className="col-md-3">
            <img src={packageImages[index]} className="card-img img-fluid" alt="Package" />
          </div>
          <div className="col-md-9">
            <div className="card-body">
              {packageData && (
                <>
                  <h5 className="card-title">{packageData.name}</h5>
                  <p className="card-text">Details: {packageData.details}</p>
                  <div className="card-body">
                    <Link to={`/packagedata/${index + 6}`} className="card-link">View More....</Link>
                  </div>
                </>
              )}
            </div>
          </div>
        </div>
      ))}
    </div>
  );
}

export default PackageBodyM;
