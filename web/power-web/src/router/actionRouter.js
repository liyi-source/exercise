
import PowerMian from '@/views/powerMain'
import ChatList from '@/views/chatList'
import Chat from '@/views/chat'
import Menu from '@/views/footer'

import NearList from '@/views/chat/chatList'
import ChatRoom from '@/views/chat/chat'
import LoginChat from '@/views/chat/login'
import Index from '@/views/chat/index'
import MySelf from '@/views/chat/wd'
import Footer from '@/views/chat/footer'
import Friends from '@/views/chat/friends'
import AddFriend from '@/views/chat/addFriend'


export default[
    {path: '/powerMian',name: 'powerMian',component: PowerMian},
    {path: '/chatList',name: 'chatList',component: ChatList},
    {path: '/chat/:id/:data',name: 'chat',component: Chat},
    {path: '/menu',name: 'menu',component: Menu},
    

    {path: '/loginChat',name: 'loginChat',component: LoginChat},
    {path: '/chatRoom/:id/:data',name: 'chatRoom',component: ChatRoom},
    {path: '/index',name: 'index',component: Index,
        // children:[
            // {path: '/',name: 'nearList',component: NearList},
            // {path: '/nearList',name: 'nearList',component: NearList},
            // {path: '/mySelf',name: 'mySelf',component: MySelf},
            // {path: '/footer',name: 'footer',component: Footer},
            // {path: '/friends',name: 'friends',component: Friends},
            // {path: '/addUser',name: 'addUser',component: AddUser}
        // ]
    },
    {path: '/addFriend',name: 'addFriend',component: AddFriend}
]