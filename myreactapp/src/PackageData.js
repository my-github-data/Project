import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import Navbar from './Navbar';
import Footer from './Footer';
import "./PackageData.css"

function PackageData() {
    const { id } = useParams();
    const [packageData, setPackageData] = useState(null);
    const [showModal, setShowModal] = useState(false);
    const [booking, setBooking] = useState({ noOfTickets: "" })
    const [message, setMessage] = useState("");
    const url = "http://localhost:8080/booking/add";

    const getUserIdFromStorage = () => {
        const userId = localStorage.getItem('userId');
        return userId;
    };

    useEffect(() => {
        async function fetchPackageDetails() {
            try {
                const response = await axios.get(`http://localhost:8080/package/viewPackage/${id}`);
                setPackageData(response.data);
            } catch (error) {
                console.error('Error fetching package details:', error);
            }
        }
        fetchPackageDetails();
    }, [id]);

    const openModal = () => setShowModal(true);
    const closeModal = () => setShowModal(false);

    if (!packageData) {
        return <div>Loading...</div>;
    }

    const OnTextChange = (args) => {
        var booking1 = { ...booking }
        booking1[args.target.name] = args.target.value;
        setBooking(booking1);
    }
    const showMessage = (msgText) => {
        setMessage(msgText);
        window.setTimeout(() => {
            setMessage("");
        }, 3000);
    }
    const BookPackage = () => {
        const userId = getUserIdFromStorage();

        // Check if user ID is available
        if (!userId) {
            console.error('User ID not found');
            return;
        }
        const bookingData = {
            ...booking,
            userId: userId, // Include user ID
            packageId: id    // Include package ID from params
        };

        // Send a POST request to book the package
        axios.post(url, bookingData)
            .then((result) => {
                if (result.data != null) {
                    console.log(result);
                    showMessage("Booked Successfully!!");
                }
            })
            .catch((error) => {
                console.error('Error while booking:', error);
                if (error.response) {
                    console.error('Response data:', error.response.data);
                    console.error('Response status:', error.response.status);
                    console.error('Response headers:', error.response.headers);
                } else if (error.request) {
                    console.error('No response received. Request:', error.request);
                } else {
                    console.error('Error setting up the request:', error.message);
                }
                showMessage("Error while booking. Please try again.");
            });
    };
    return (
        <>
            <Navbar />
            <div className="containerde">
                <div className="row justify-content-center align-items-center">
                    <div className="col-md-4">
                        <div className="card pack">
                            <div className="card-body text-center">
                                <br />
                                <h2>{packageData.name}</h2>
                                <br />
                                <p>Price: {packageData.price}</p>
                                <p>From Date: {packageData.fromDate}</p>
                                <p>To Date: {packageData.toDate}</p>
                                <p>Type: {packageData.type}</p>
                                <button type="button" className="btn btn-outline-secondary" onClick={openModal}>
                                    Book Now
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            {showModal && (
                <div className="modal fade show" tabIndex="-1" role="dialog" style={{ display: 'block' }}>
                    <div className="modal-dialog" role="document">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h5 className="modal-title">Booking Details</h5>
                                <button type="button" className="close" onClick={closeModal}>
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div className="modal-body">
                                <input name="noOfTickets" placeholder="No. Of Tickets" value={booking.noOfTickets} onChange={OnTextChange} />
                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-secondary" onClick={closeModal}>Cancel</button>
                                <button type="button" className="btn btn-primary" onClick={BookPackage}>Book</button>
                            </div>
                        </div>
                    </div>
                </div>
            )}
            <Footer />
        </>
    );
}

export default PackageData;
