function jsonp({url,params,callback}){
    console.log(params)
    let script = document.createElement('script')

    return new Promise((resolve,reject)=>{
        window[callback] = function(data){
            resolve(data)
            document.body.removeChild(script)
        }
        params = {...params,callback}
        let arrs = []
        for(let key in params)
            arrs.push(`${key}=${params[key]}`)
        script.src = `${url}?${arrs.join('&')}`
        document.body.appendChild(script)

    })

}