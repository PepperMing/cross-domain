---
title: 跨域
date: 2019-04-12 17:31:01
tags: web
---


这里记载 7 种跨域的方式

<!-- 前端处理、后端处理 -->
1. jsonp
2. cors
3. postMessage
4. document-domain
5. <span>window.name</span>
6. location.hash
7.  webSocket

详细的 demo [查看这里](https://github.com/PepperMing/cross-domain)，对于 cors 提供了 SpringBoot 配置类的信息。其他的全部都是使用 express 实现，WebSocket 使用了 ws 模块。

由于有着浏览器的同源策略（same origin policy）这样的安全限制。在同源策略的限制下，非同源的网站之间不能发送 ajax 请求的。同源即同样的协议、域名、端口。

[关于域名](https://zh.wikipedia.org/wiki/%E5%9F%9F%E5%90%8D)
从右到左，依次下降一级。最右边的则是顶级域名诸如 .com 、.org 、.cn 


---
### jsonp
jsonp 的原理，使用 script 标签去做请求，绕过浏览器的同源策略约束。
jsonp 的缺点：只能使用 get 请求，不安全，容易引起 xss 攻击

---
### cors
[cors（Cross-Origin Resource Sharing）](http://www.ruanyifeng.com/blog/2016/04/cors.html), 跨资源共享，是一个 W3C 的标准，它允许浏览器直接向服务器发出跨域请求，使用方式和普通的 Ajax 请求方式一样，主要是服务器端需要进行额外的设置。

缺点是：CORS需要浏览器和服务器同时支持。目前，所有浏览器都支持该功能，**IE浏览器不能低于IE10**。
---
### postMessage
postMessage,利用的是主页面与 iframe 之间的通信。其使用 window 对象的 postMessage 方法。通过 window 的 message 事件进行监听消息的传输。

---
# document-domain
document-domain 只需要通信的两个页面 document.domain 声明在相同的域名下，就可以进行通信。不过由于只能用于**一级域名和其下级域名之间**的通信，由于条件有限，在此不过多叙述。

```js
document.domain = 'xxx.com' // A 页面
document.domain = 'xxx.com' // B 页面
```

---
### <span>window.name</span>
<span>window.name</span>则是通过页面的 iframe 标签可以引入其他源的内容，因此使用 使用一个 iframe 进行请求资源

![iframe.name](https://pepper-huanan1-blog-001.oss-cn-shenzhen.aliyuncs.com/blog/img/mspaint_GxAKbHYPL9.png)

---
### location.hash

路径后的 hash 可以用来通信。。这个方式类似于上述的方式。简单来说就是将传递的数据保存在 location.hash 中。
假设 A、B 同源，C 相对于 A、B 是不同的域
那么， A 将 location.hash 传递给 C
C 接受后，将响应的值传递给 B
A、B 同源，因此 B 改变 A 的值。以此达到跨域的效果。


---
### webScoket

使用 webScoket 就不存在跨域的问题（因为使用的不是 http 的协议），相比于 http 只存在客户端向服务器发送请求，服务器进行响应的单向通信。webScoket 支持双向的通信方式（即服务器可以主动向客户端发送信息）。
