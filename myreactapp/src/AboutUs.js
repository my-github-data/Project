import React from 'react'
import Navbar from './Navbar';
import Footer from './Footer';
import TourNestImage from "./images/TourNest.png";
import './AboutUs.css'
import { FaBullseye, FaEye, FaMapMarkedAlt, FaPlane, FaTags, FaUsers } from 'react-icons/fa';
import { Link } from 'react-router-dom';

function AboutUs() {
    return (
        <>
            <Navbar />
            <div className="container-fluid">
                <div className="row">
                    <div className="col-md-3 tour">
                        <img src={TourNestImage} className="card-img img-fluid tournest" alt="aboutus" />
                    </div>
                    <div className="col-md-9">
                        <div className="card-body">
                            <h5 className="card-title">TourNest</h5>
                            <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.Some quick example text to build on the card title and make up the bulk of the card's content.Some quick example text to build on the card title and make up the bulk of the card's content.Some quick example text to build on the card title and make up the bulk of the card's content.Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        </div>
                    </div>
                </div>
            </div>
            <br />
            <hr />
            <div className="row row-cols-1 row-cols-md-3 g-4">
                <div className="col">
                    <div className="card border-0">
                        <div className="card-body">
                            <div className='about_icon text-center'><FaEye /></div>
                            <h5 className="card-title text-center">Vision</h5>
                            <p className="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        </div>
                    </div>
                </div>
                <div className="col">
                    <div className="card border-0">
                        <div className="card-body">
                            <div className='about_icon text-center'><FaBullseye /></div>
                            <h5 className="card-title text-center">Mission</h5>
                            <p className="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        </div>
                    </div>
                </div>
                <div className="col">
                    <div className="card border-0">
                        <div className="card-body">
                            <div className='about_icon text-center'><FaTags /></div>
                            <h5 className="card-title text-center">Best Deal</h5>
                            <p className="card-text">This is a longer card with supporting text below as a natural lead-in to additional content.</p>
                        </div>
                    </div>
                </div>
            </div>
            <div className="row row-cols-1 row-cols-md-3 g-4">
                <div className="col">
                    <div className="card border-0">
                        <div className="card-body">
                            <div className='about_icon text-center'><FaUsers /></div>
                            <h5 className="card-title text-center">Customers Are Our Priority</h5>
                            <p className="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        </div>
                    </div>
                </div>
                <div className="col">
                    <div className="card border-0">
                        <div className="card-body">
                            <div className='about_icon text-center'><FaPlane /></div>
                            <h5 className="card-title text-center">We Make Travel Easy</h5>
                            <p className="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        </div>
                    </div>
                </div>
                <div className="col">
                    <div className="card border-0">
                        <div className="card-body">
                            <div className='about_icon text-center'><FaMapMarkedAlt /></div>
                            <h5 className="card-title text-center">Superb Destinations</h5>
                            <p className="card-text">This is a longer card with supporting text below as a natural lead-in to additional content.</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="text-center">
                <Link to="/feedback" className="btn btn-outline-secondary">Feedback</Link>
            </div>
            <Footer />
        </>
    )
}
export default AboutUs;
