import axios from 'axios'
// import {getUser} from '@/utils/auth'
// 创建axios实例
const service = axios.create({
    //开发环境
    baseURL: 'http://localhost:9000', // api的base_url

    //上线环境
    // baseURL: 'http://139.196.161.254:9000', // api的base_url
    timeout: 30000 ,// 请求超时时间
    // eslint-disable-next-line no-irregular-whitespace
    // headers: { 'Authorization': 'Bearer '+getUser().token过期处理
    // }
  })
export default service