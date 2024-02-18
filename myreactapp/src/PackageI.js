import React from 'react'
import Navbar from './Navbar';
import PackageBodyI from './PackageBodyI';
import Footer from './Footer';

function PackageI() {
    return (
        <div className='package'>
                <Navbar />
            <div className='packagebodyi'>
                <PackageBodyI />
                <Footer />
            </div>
        </div>
    )
}
export default PackageI;