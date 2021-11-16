#!groovy
library 'comm-parent'

def map = [:]

// sonar config
map.sonarScannerTool = 'sonarScanner'       //设置sonar代码扫描器
map.sonarQulityGate = 'sonar'               //设置sonar服务
map.sonarEnv = 'sonar'                      //设置sonar环境

// maven config
map.mavenSkipTest='true'                    //maven单元测试开关
map.mavenParams='-U'                        //maven执行参数

// docker config
map.dockerProtocol = 'https'
map.dockerRegistry = 'reg.int.it2000.com.cn'        //设置docker镜像服务器ip
map.dockerUrl='https://reg.int.it2000.com.cn'       //设置docker镜像服务地址
map.dockerSecretId='privateDockerId'        //设置docker镜像密码
map.dockerJarFileDir='event-server/target'               //设置服务jar包目录
map.dockerJarFileName='event-server'        //设置服务jar包名称

// deploy config
map.deployHostName = 'dev-event'             //设置docker部署服务器名称（可以任意，建议和项目名称保存一致）
map.deployHostIp = '130.120.3.253'           //设置docker部署服务器IP地址
map.deployCredentialsId = 'e41b57a4-436a-4617-817c-9e3f25a8a47f'    //设置Jenkins中docker服务器ssh秘钥id
map.deploySwarm = 'dev'                    //设置docker集群名称
map.deployService = 'event'          //设置docker服务名称,gateway中需和这里保持一致

map.mailTo = 'yangguangj@it2000.com.cn'             //设置构建结果通知邮箱地址，多个逗号分隔

// aifaMinsPipeline(map)
aifaMinsNpmPipeline(map)
