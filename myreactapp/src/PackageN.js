import React from 'react'
import Navbar from './Navbar';
import PackageBodyN from './PackageBodyN';
import Footer from './Footer';

function PackageN() {
    return (
        <div className='package'>
                <Navbar />
            <div className='packagebodyn'>
                <PackageBodyN />
                <Footer />
            </div>
        </div>
    )
}
export default PackageN;