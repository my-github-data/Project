import React from 'react'
import Navbar from './Navbar';
import Footer from './Footer';
import PackageBodyM from './PackageBodyM';
import PackageBodyN from './PackageBodyN';
import PackageBodyI from './PackageBodyI';


function Package() {
    return (
        <>
            <Navbar />
            <PackageBodyM />
            <PackageBodyN />
            <PackageBodyI />
            <Footer />
        </>
    )
}
export default Package;