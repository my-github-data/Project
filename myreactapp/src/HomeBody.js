import React from 'react'
import backpack from "./images/backpack.jpg";
import disney from "./images/disney.jpg";
import gateway from "./images/gateway.jpg";
import himalaya from "./images/himalaya.jpg";
import hogwarts from "./images/hogwarts.jpg";
import maldives from "./images/maldives.jpg";
import meghalaya from "./images/meghalaya.jpg";
import punetrek from "./images/punetrek.jpg";
import south from "./images/south.jpg";
import './HomeBody.css';
import { Link } from 'react-router-dom';

function HomeBody() {
    return (
        <>
            <div className="bar"><p className='must'>Must do trips</p></div>
            <div className="row row-cols-1 row-cols-md-3 g-4">
                <div className="col">
                    <Link to={`/packagedata/${6}`} className="card-link">
                        <div className="card">
                            <img src={gateway} className="card-img-top" alt="MumbaiGateway" />
                            <div className="card-body">
                                <h5 className="card-title">Mumbai Weekend Gateway</h5>

                                <p className="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                            </div>
                        </div>
                    </Link>
                </div>
                <div className="col">
                    <Link to={`/packagedata/${7}`} className="card-link">
                        <div className="card">
                            <img src={punetrek} className="card-img-top" alt="PuneTrek" />
                            <div className="card-body">
                                <h5 className="card-title">Sahyadri Treks Pune</h5>
                                <p className="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                            </div>
                        </div>
                    </Link>
                </div>
                <div className="col">
                    <div className="card">
                        <img src={backpack} className="card-img-top" alt="BackPack" />
                        <div className="card-body">
                            <h5 className="card-title">Backpacking Trips</h5>
                            <p className="card-text">This is a longer card with supporting text below as a natural lead-in to additional content.</p>
                        </div>
                    </div>
                </div>
                <a className="more" href="/packagesm"><h6>Click for more....</h6></a>
            </div>
            <div className="bar"><p className='must'>Places we can take you to</p></div>
            <div className="row row-cols-1 row-cols-md-3 g-4">
                <div className="col">
                    <Link to={`/packagedata/${11}`} className="card-link">
                        <div className="card">
                            <img src={meghalaya} className="card-img-top" alt="MeghalayaTrip" />
                            <div className="card-body">
                                <h5 className="card-title">Meghalaya Trips</h5>
                                <p className="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                            </div>
                        </div>
                    </Link>
                </div>
                <div className="col">
                    <Link to={`/packagedata/${12}`} className="card-link">
                        <div className="card">
                            <img src={south} className="card-img-top" alt="SouthTrip" />
                            <div className="card-body">
                                <h5 className="card-title">South Trips</h5>
                                <p className="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                            </div>
                        </div>
                    </Link>
                </div>
                <div className="col">
                    <Link to={`/packagedata/${13}`} className="card-link">
                        <div className="card">
                            <img src={himalaya} className="card-img-top" alt="HimalayaTrek" />
                            <div className="card-body">
                                <h5 className="card-title">Himalaya Treks</h5>
                                <p className="card-text">This is a longer card with supporting text below as a natural lead-in to additional content.</p>
                            </div>
                        </div>
                    </Link>
                </div>
                <a className="more" href="/packagesn"><h6>Click for more....</h6></a>
            </div>
            <div className="bar"><p className='must'>Where you can get unique experiences</p></div>
            <div className="row row-cols-1 row-cols-md-3 g-4">
                <div className="col">
                    <Link to={`/packagedata/${16}`} className="card-link">
                        <div className="card">
                            <img src={hogwarts} className="card-img-top" alt="HogwartsTrip" />
                            <div className="card-body">
                                <h5 className="card-title">Magical Trip to Hogwarts</h5>
                                <p className="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                            </div>
                        </div>
                    </Link>
                </div>
                <div className="col">
                    <Link to={`/packagedata/${17}`} className="card-link">
                        <div className="card">
                            <img src={disney} className="card-img-top" alt="Disneyland" />
                            <div className="card-body">
                                <h5 className="card-title">Visit to Disneyland</h5>
                                <p className="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                            </div>
                        </div>
                    </Link>
                </div>
                <div className="col">
                    <Link to={`/packagedata/${18}`} className="card-link">
                        <div className="card">
                            <img src={maldives} className="card-img-top" alt="Maldives" />
                            <div className="card-body">
                                <h5 className="card-title">Maldives</h5>
                                <p className="card-text">This is a longer card with supporting text below as a natural lead-in to additional content.</p>
                            </div>
                        </div>
                    </Link>
                </div>
                <a className="more" href="/packagesi"><h6>Click for more....</h6></a>
            </div>
            <br />
        </>
    )
}
export default HomeBody;