import React from 'react';
import { Button } from 'antd';
import {useHistory} from 'react-router-dom';



function HomePage () {

    const history = useHistory();

    const toWelcome = () => {
        history.push("/welcome");
    };

    return (
        <div>
            <p>This is HomePage.</p>
            <Button htmlType="button" onClick={toWelcome}>
                Welcome
            </Button>
            <div>
                <iframe id="testdemo" title="testdemo" width="100%" height="1000px"
                    src="http://localhost:8080/webroot/decision/v10/entry/access/b66997fc-6cc0-40ce-ad50-db7199d1d096"></iframe>
            </div>
        </div>
    );
}

export default HomePage;