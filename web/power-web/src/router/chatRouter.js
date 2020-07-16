import NearList from '@/views/chat/chatList'
import ChatRoom from '@/views/chat/chat'
import LoginChat from '@/views/chat/login'
import Index from '@/views/chat/index'


export default[
    {path: '/loginChat',name: 'loginChat',component: LoginChat},
    {path: '/index',name: 'index',component: Index,children:[
        {path: '/',name: 'nearList',component: NearList},
        {path: '/nearList',name: 'nearList',component: NearList},
        {path: '/chatRoom/:id/:data',name: 'chat',component: ChatRoom}
    ]},
]