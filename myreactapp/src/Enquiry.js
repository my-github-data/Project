import React from 'react'
import "./Enquiry.css"
import Navbar from './Navbar';
import Footer from './Footer';
import { FaEnvelope, FaPhone, FaWhatsapp } from 'react-icons/fa';

function Enquiry() {
    return (
        <>
            <Navbar />
            <div class="contact_container">
                <h2>Reach Us Out</h2>
                <div class="g_map">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3770.3884487839077!2d72.86047081363212!3d19.090607469429532!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3be7c85099bd2947%3A0x1ecc1a60c474a8ae!2sChhatrapati%20Shivaji%20Maharaj%20International%20Airport!5e0!3m2!1sen!2sin!4v1648118913456!5m2!1sen!2sin" allowFullScreen="" loading="lazy"></iframe>
                </div>
                <div className='contact_icons'>
                    <a href="https://api.whatsapp.com/send?phone=+919307824951" target="_blank"><FaWhatsapp /></a>
                    <a href="tel: +919307824951" target="_blank"><FaPhone /></a>
                    <a href="mailto: pranotibawaskar@gmail.com" target="_blank"><FaEnvelope /></a>
                </div>
                <div class="contact_content">
                    <p><b>Address: Pune, Maharashtra</b></p>
                    <p><b>Call: +91 9876876876</b></p>
                    <p><b>Mail: TourNest@gmail.com</b></p>
                </div>
            </div>
            <Footer />
        </>
    )
}
export default Enquiry;
