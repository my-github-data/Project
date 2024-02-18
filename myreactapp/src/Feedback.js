import React, { useState } from 'react';
import Navbar from './Navbar';
import Footer from './Footer';
import './Feedback.css';
import axios from 'axios';
import { FaSmileBeam } from 'react-icons/fa';

function Feedback() {
    const [feedback, setFeedback] = useState({ feedback: '' });
    const [message, setMessage] = useState('');
    const [showModal, setShowModal] = useState(false);
    const url = 'http://localhost:8080/feedback/add';

    const getUserIdFromStorage = () => {
        const userId = localStorage.getItem('userId');
        return userId;
    };

    const OnTextChange = (args) => {
        const feedback1 = { ...feedback };
        feedback1[args.target.name] = args.target.value;
        setFeedback(feedback1);
    };

    const showMessage = (msgText) => {
        setMessage(msgText);
        window.setTimeout(() => {
            setMessage('');
        }, 3000);
    };

    const GiveFeedback = () => {
        const userId = getUserIdFromStorage();

        // Check if user ID is available
        if (!userId) {
            console.error('User ID not found');
            return;
        }

        // Check if feedback is entered
        if (!feedback.feedback) {
            alert('Please write something');
            return;
        }

        const feedbackData = {
            ...feedback,
            userId: userId, // Include user ID
        };

        // Send a POST request to submit the feedback
        axios
            .post(url, feedbackData)
            .then((result) => {
                if (result.data != null) {
                    console.log(result);
                    setShowModal(true); // Show modal after successful submission
                    setFeedback({ feedback: '' }); // Clear the feedback input
                }
            })
            .catch((error) => {
                console.error('Error while giving feedback:', error);
                if (error.response) {
                    console.error('Response data:', error.response.data);
                    console.error('Response status:', error.response.status);
                    console.error('Response headers:', error.response.headers);
                } else if (error.request) {
                    console.error('No response received. Request:', error.request);
                } else {
                    console.error('Error setting up the request:', error.message);
                }
                showMessage('Error while giving feedback. Please try again.');
            });
    };

    return (
        <>
            <Navbar />
            <div className="containerfe">
                <div className="row justify-content-center align-items-center">
                    <div className="col-md-4">
                        <div className="card feed">
                            <div className="card-body text-center">
                                <br />
                                <h2>Feedback</h2>
                                <br />
                                <br />
                                <br />
                                <br />
                                <input placeholder="Share us your feedback" name="feedback" value={feedback.feedback} onChange={OnTextChange} />
                                <br />
                                <br />
                                <button type="button" className="btn btn-outline-secondary" onClick={GiveFeedback}>
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
                                <h5 className="modal-title">Feedback Submitted</h5>
                                <button type="button" className="close" onClick={() => setShowModal(false)}>
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div className="modal-body">
                                <p>Thank you for your feedback!&nbsp;<FaSmileBeam /></p>
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

export default Feedback;
