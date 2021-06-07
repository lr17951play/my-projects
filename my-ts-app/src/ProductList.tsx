import React from 'react';
import {useState} from 'react';
import { Table, Tag, Space } from 'antd';
import _data from './data.json'
import * as style from './style/ProductList.module.less'
import {UserAddOutlined} from '@ant-design/icons'
import AddNew from './AddNew';


const columns = [
    {
      title: 'Name',
      dataIndex: 'name',
      key: 'name',
      render: (text: string) => <a>{text}</a>,
    },
    {
      title: 'Age',
      dataIndex: 'age',
      key: 'age',
    },
    {
      title: 'Address',
      dataIndex: 'address',
      key: 'address',
    },
    {
      title: 'Tags',
      key: 'tags',
      dataIndex: 'tags',
      render: (tags: string[]) => (
        <>
          {tags.map((tag: string) => {
            let color = tag.length > 5 ? 'geekblue' : 'green';
            if (tag === 'loser') {
              color = 'volcano';
            }
            return (
              <Tag color={color} key={tag}>
                {tag.toUpperCase()}
              </Tag>
            );
          })}
        </>
      ),
    },
    {
      title: 'Action',
      key: 'action',
      render: (text: any, record: { name: string }) => (
        <Space size="middle">
          <a>Invite {record.name}</a>
          <a>Delete</a>
        </Space>
      ),
    },
  ];

  const ProductList: React.FC = () => {
    const data = _data;
    const [visible, setVisible] = useState(false);

    const showAddDialog = () => {
      setVisible(true);
    }

    const footer = () => {
      return(
        <UserAddOutlined onClick = {showAddDialog} className = {style.footer}/>
      );
    }

    return (
        <div>
            <Table columns = {columns} dataSource = {data} className = {style.tableData} footer = {footer}/>
            <AddNew visible = {visible} setVisible = {setVisible}/>
        </div>
    );
  }

  export default ProductList;