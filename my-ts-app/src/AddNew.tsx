import React from 'react';
import { Modal, Form, Input, InputNumber, Button, Select } from 'antd';
import { UserOutlined } from '@ant-design/icons';
import * as style from './style/AddNew.module.less'

interface PropItems {
    visible: boolean;
    setVisible: (visible: boolean) => void;
}

const AddNew: React.FC<PropItems> = ({visible, setVisible}) => {

    const handleOk = (e : any) => {
        console.log(e);
        setVisible(false);
    }

    const handleCancel = (e : any) => {
        console.log(e);
        setVisible(false);
    }

    const handleSubmit = () => {
        
    }

    const handleFailed = () => {

    }

    const options = [{ value: 'gold' }, { value: 'lime' }, { value: 'green' }, { value: 'cyan' }];


    return (
        <Modal
            title="Basic Modal"
            visible={visible}
            onOk={handleOk}
            onCancel={handleCancel}
            footer={[
                <Button key="back" onClick={handleCancel}>Return</Button>,
                <Button type="primary" htmlType="submit" onClick={handleSubmit}>Submit</Button>
              ]}
        >
            <Form
                name="basic"
                initialValues={{ remember: true }}
                onFinish={handleSubmit}
                onFinishFailed={handleFailed}
                className={style.form}
                >
                <Form.Item
                    label={<span className={style.item}>UserName</span>}
                    name="username"
                    rules={[{ required: true, message: 'Please input your username!'}]}
                >
                    <Input placeholder="enter user name please" prefix={<UserOutlined />}/>
                </Form.Item>

                <Form.Item
                    label={<span className={style.item}>Age</span>}
                    name="age"
                    rules={[{ required: true, message: 'Please input your age!' }]}
                >
                   <InputNumber placeholder="enter user age" min={1} max={100}/>
                </Form.Item>

                <Form.Item
                    label={<span className={style.item}>Address</span>}
                    name="address"
                    rules={[{ required: true, message: 'Please input your address!' }]}
                >
                    <Input.Group compact>
                        <Select style={{ width: '30%' }} defaultValue="Home">
                            <Select value="Home">Home</Select>
                            <Select value="Company">Company</Select>
                        </Select>
                        <Input placeholder="enter user address please" />
                    </Input.Group>
                </Form.Item>

                <Form.Item
                    label={<span className={style.item}>Tags</span>}
                    name="tags"
                    rules={[{ required: true, message: 'Please select your tags!' }]}
                >
                    
                </Form.Item>
                {/* <Form.Item>
                    <Button type="primary" htmlType="submit">
                    Submit
                    </Button>
                </Form.Item> */}
            </Form>
        </Modal>
    );
}

export default AddNew;