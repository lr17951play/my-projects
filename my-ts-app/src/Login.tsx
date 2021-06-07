import React from 'react';
import { Form, Input, Button } from 'antd';
import {useHistory} from 'react-router-dom';
import * as css from './style/Login.module.less';

export interface LoginProps {
    username : string;
    password : string;
}


const layout = {
  labelCol: { span: 8 },
  wrapperCol: { span: 16 },
};
const tailLayout = {
  wrapperCol: { offset: 8, span: 16 },
};

const Login = () => {
  const [form] = Form.useForm();
  const history = useHistory();

  const onFinish = (values: any) => {
    const { username, password } = values;
    if (username === 'admin' && password === 'admin') {
      console.log(username);
        history.push("/welcome");
    } else {
        console.log('username or password invalid');
    }
  };

  const onReset = () => {
    form.resetFields();
  };

  const onFill = () => {
    form.setFieldsValue({
      username: 'admin',
      password: 'admin',
    });
  };

  return (
    <Form {...layout} form={form} name="control-hooks" onFinish={onFinish} className={css.contain}>
      <Form.Item name="username" label="Username" rules={[{ required: true }]} className={css.demo}>
        <Input placeholder="username"/>
      </Form.Item>
      <Form.Item name="password" label="Password" rules={[{ required: true }]}>
        <Input placeholder="password" type="password"/>
      </Form.Item>
      <Form.Item {...tailLayout}>
        <Button type="primary" htmlType="submit">
          Submit
        </Button>
        <Button htmlType="button" onClick={onReset}>
          Reset
        </Button>
        <Button type="link" htmlType="button" onClick={onFill}>
          Fill form
        </Button>
      </Form.Item>
    </Form>
  );
};

export default Login;