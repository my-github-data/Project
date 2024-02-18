import React from 'react'
import Navbar from './Navbar';
import PackageBodyM from './PackageBodyM';
import Footer from './Footer';

function PackageM() {
    return (
        <div className='package'>
                <Navbar />
            <div className='packagebodym'>
                <PackageBodyM />
                <Footer />
            </div>
        </div>
    )
}
export default PackageM;