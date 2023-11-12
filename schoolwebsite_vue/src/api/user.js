import request from '@/utils/request'
const api_name = 'api'
export default{
    login(pojo){
        return request({
            url:`/login`,
            method:'post',
            data:pojo
        })
    },
    setPassword(pojo){
        return request({
            url:`/setpw`,
            method:'post',
            data:pojo
        })
    },
    getName(account){
        return request({
            url:`/getname`,
            method:'post',
            data:account
        })
    },
    getAllNews(){
        return request({
            url:`/getnews`,
            method:'get'
        })
    },
    add_news(pojo){
        return request({
            url:`/addnews`,
            method:'post',
            data:pojo
        })
    },
    getCourses(tea_id){
        return request({
            url:`/getcourses`,
            method:'post',
            data:tea_id
        })
    },
    getStuProj(stu_id){
        return request({
            url:`/getstuproj?stu_id=`+stu_id,
            method:'post'
        })
    },
    getTeaProj(tea_id){
        return request({
            url:`/getteaproj?tea_id=`+tea_id,
            method:'post',
        })
    },
    getStuNews(stu_id){
        return request({
            url:`/getstunews`,
            method:'post',
            data:stu_id
        })
    },
    getTeaNews(tea_id){
        return request({
            url:`/getteanews`,
            method:'post',
            data:tea_id
        })
    },
    addProj(pojo){
        return request({
            url:`/addproj`,
            method:'post',
            data:pojo
        })
    },
    upCour(pojo){
        return request({
            url:`/upcour`,
            method:'post',
            data:pojo
        })
    },
    downLoad(fileName){
        return request({
            url:`/download?fileName=`+fileName,
            method:'post',
        })
    },
    delProj(filename){
        return request({
            url:`/deleteproj?filename=`+filename,
            method:'post',
        })
    },
    getStuCour(stu_id){
        return request({
            url:`/getstucour?stu_id=`+stu_id,
            method:'post',
        })
    },
    getTeaCour(tea_id){
        return request({
            url:`/getteacour?tea_id=`+tea_id,
            method:'post',
        })
    },
    getTeaStuProj(cour_id){
        return request({
            url:`/getteastuproj?cour_id=`+cour_id,
            method:'post',
        })
    },




    getUserListByCondition(pojo){
        return request({
            url:`/${api_name}/getuserlistbycondition`,
            method:'post',
            data:pojo
        })
    },
    getUserInfoByCondition(pojo){
        return request({
            url:`/${api_name}/getuserinfobycondition`,
            method:'post',
            data:pojo
        })
    },
    addUser(pojo){
        return request({
            url:`/${api_name}/adduser`,
            method:'post',
            data:pojo
        })
    },
    updateUser(pojo){
        return request({
            url:`/${api_name}/updateuser`,
            method:'post',
            data:pojo
        })
    },
    deleteUser(id){
        return request({
            url:`/${api_name}/deleteuser?userListid=`+id,
            method:'delete',
        })
    },
    editPassword(pojo){
        return request({
            url:`/${api_name}/editpassword`,
            method:'post',
            data:pojo
        })
    },

    
}







