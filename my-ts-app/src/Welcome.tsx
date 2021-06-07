import React from 'react';
import { Button } from 'antd';
import ProductList from './ProductList';
import {useHistory} from 'react-router-dom';



function Welcome () {

    const history = useHistory();

    const toHomepage = () => {
        history.push("/homepage");
    };

    return (
        <div>
            <p>This is Welcome Page.</p>
            <Button htmlType="button" onClick={toHomepage}>
                HomePage
            </Button>
            <ProductList/>
        </div>
    );
}

export default Welcome;