import React from 'react'
import Navbar from './Navbar';
import HomeBody from './HomeBody';
import Footer from './Footer';
import "./Home.css"

function Home() {
    return (
        <div className='home'>
                <Navbar />
            <div className='homebody'>
                <HomeBody />
                <Footer />
            </div>
        </div>
    )
}
export default Home;