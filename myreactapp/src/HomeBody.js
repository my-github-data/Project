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

function HomeBody() {
    return (
        <>
            <div class="bar"><p class='must'>Must do trips</p></div>
            <div class="row row-cols-1 row-cols-md-3 g-4">
                <div class="col">
                    <div class="card">
                        <img src={gateway} class="card-img-top" alt="MumbaiGateway" />
                        <div class="card-body">
                            <h5 class="card-title">Mumbai Weekend Gateway</h5>
                            <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card">
                        <img src={punetrek} class="card-img-top" alt="PuneTrek" />
                        <div class="card-body">
                            <h5 class="card-title">Sahyadri Treks Pune</h5>
                            <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card">
                        <img src={backpack} class="card-img-top" alt="BackPack" />
                        <div class="card-body">
                            <h5 class="card-title">Backpacking Trips</h5>
                            <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content.</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="bar"><p class='must'>Places we can take you to</p></div>
            <div class="row row-cols-1 row-cols-md-3 g-4">
                <div class="col">
                    <div class="card">
                        <img src={meghalaya} class="card-img-top" alt="MeghalayaTrip" />
                        <div class="card-body">
                            <h5 class="card-title">Meghalaya Trips</h5>
                            <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card">
                        <img src={south} class="card-img-top" alt="SouthTrip" />
                        <div class="card-body">
                            <h5 class="card-title">South Trips</h5>
                            <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card">
                        <img src={himalaya} class="card-img-top" alt="HimalayaTrek" />
                        <div class="card-body">
                            <h5 class="card-title">Himalaya Treks</h5>
                            <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content.</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="bar"><p class='must'>Where you can get unique experiences</p></div>
            <div class="row row-cols-1 row-cols-md-3 g-4">
                <div class="col">
                    <div class="card">
                        <img src={hogwarts} class="card-img-top" alt="HogwartsTrip" />
                        <div class="card-body">
                            <h5 class="card-title">Magical Trip to Hogwarts</h5>
                            <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card">
                        <img src={disney} class="card-img-top" alt="Disneyland" />
                        <div class="card-body">
                            <h5 class="card-title">Visit to Disneyland</h5>
                            <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card">
                        <img src={maldives} class="card-img-top" alt="Maldives" />
                        <div class="card-body">
                            <h5 class="card-title">Maldives</h5>
                            <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content.</p>
                        </div>
                    </div>
                </div>
            </div>
            <br />
        </>
    )
}
export default HomeBody;