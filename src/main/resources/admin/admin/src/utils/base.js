const base = {
    get() {
        return {
            url : "http://localhost:8080/springboots6ag7/",
            name: "springboots6ag7",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboots6ag7/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "线上公安办事系统"
        } 
    }
}
export default base
