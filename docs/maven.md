### maven学习记录

- dependencyManagement 只是用来控制版本，并不真正引入依赖。
- exclusions 用于排除依赖
- RELEASE 版本的 jar 包是不会主动去使用最新的，SNAPSHOT 版本则会在启动时到仓库获取最新的 jar 包
- 