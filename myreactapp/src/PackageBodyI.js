import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './PackageBody.css';
import hogwarts from './images/hogwarts.jpg';
import disney from './images/disney.jpg';
import maldives from './images/maldives.jpg';
import singapore from './images/singapore.jpg';
import fuji from './images/fuji.jpg';
import { Link } from 'react-router-dom';

function PackageBodyI() {
    const [packages, setPackages] = useState([]);

    useEffect(() => {
        async function fetchData() {
            try {
                const packageResponses = await Promise.all(
                    Array.from({ length: 5 }, (_, index) =>
                        axios.get(`http://localhost:8080/package/viewPackage/${index + 16}`)
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
    const packageImages = [hogwarts, disney, maldives, singapore, fuji];

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
                                        <Link to={`/packagedata/${index + 16}`} className="card-link">View More....</Link>
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

export default PackageBodyI;
