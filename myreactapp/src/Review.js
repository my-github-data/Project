import React, { useEffect, useState } from 'react';
import './Review.css';
import Navbar from './Navbar';
import Footer from './Footer';
import { FaSmileBeam } from 'react-icons/fa';
import axios from 'axios';
import { useParams } from 'react-router-dom';

function Review() {
    const { packageId } = useParams(); // Get the packageId from the URL params
    const [packageData, setPackageData] = useState(null);
    const [review, setReview] = useState({ review: '', rating: '' });
    const [message, setMessage] = useState('');
    const [showModal, setShowModal] = useState(false);
    const url = 'http://localhost:8080/review/add';

    const getUserIdFromStorage = () => {
        const userId = localStorage.getItem('userId');
        return userId;
    };

    useEffect(() => {
        async function fetchPackageDetails() {
            try {
                const response = await axios.get(`http://localhost:8080/package/viewPackage/${packageId}`);
                setPackageData(response.data);
            } catch (error) {
                console.error('Error fetching package details:', error);
            }
        }
        fetchPackageDetails();
    }, [packageId]); // Fetch package details whenever packageId changes

    if (!packageData) {
        return <div>Loading...</div>;
    }

    const OnTextChange = (args) => {
        const review1 = { ...review };
        review1[args.target.name] = args.target.value;
        setReview(review1);
    };

    const showMessage = (msgText) => {
        setMessage(msgText);
        window.setTimeout(() => {
            setMessage('');
        }, 3000);
    };

    const GiveReview = () => {
        const userId = getUserIdFromStorage();

        // Check if user ID is available
        if (!userId) {
            console.error('User ID not found');
            return;
        }

        // Check if feedback is entered
        if (!review.review) {
            alert('Please give the review');
            return;
        }

        const reviewData = {
            ...review,
            userId: userId, // Include user ID
            packageId: packageId, // Include packageId
        };

        // Send a POST request to submit the review
        axios
            .post(url, reviewData)
            .then((result) => {
                if (result.data != null) {
                    console.log(result);
                    setShowModal(true); // Show modal after successful submission
                    setReview({ review: '' }); // Clear the review input
                }
            })
            .catch((error) => {
                console.error('Error while giving review:', error);
                if (error.response) {
                    console.error('Response data:', error.response.data);
                    console.error('Response status:', error.response.status);
                    console.error('Response headers:', error.response.headers);
                } else if (error.request) {
                    console.error('No response received. Request:', error.request);
                } else {
                    console.error('Error setting up the request:', error.message);
                }
                showMessage('Error while giving review. Please try again.');
            });
    };

    return (
        <>
            <Navbar />
            <div className="containerre">
                <div className="row justify-content-center align-items-center">
                    <div className="col-md-4">
                        <div className="card review">
                            <div className="card-body text-center">
                                <br />
                                <h2>Review</h2>
                                <br />
                                <br />
                                <br />
                                <br />
                                <input placeholder="Share your review on this package" name="review" value={review.review} onChange={OnTextChange} />
                                <input placeholder="Rating" name="rating" value={review.rating} onChange={OnTextChange} />
                                <br />
                                <br />
                                <button type="button" className="btn btn-outline-secondary" onClick={GiveReview}>
                                    Submit
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <Footer />

            {showModal && (
                <div className="modal fade show" tabIndex="-1" role="dialog" style={{ display: 'block' }}>
                    <div className="modal-dialog" role="document">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h5 className="modal-title">Review Submitted</h5>
                                <button type="button" className="close" onClick={() => setShowModal(false)}>
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div className="modal-body">
                                <p>Thank you for your Review!&nbsp;<FaSmileBeam /></p>
                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-primary" onClick={() => setShowModal(false)}>
                                    Close
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            )}
        </>
    );
}
export default Review;
