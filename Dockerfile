# 1. 使用一个包含 JDK 和 Tomcat 的基础镜像
FROM tomcat:9.0-jdk11-openjdk

# 2. 移除 Tomcat 默认的 ROOT 应用
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# 3. 将你项目构建出的 WAR 包复制到 Tomcat 的 webapps 目录下，并重命名为 ROOT.war
#    注意：下面的 "word.war" 需要替换成你项目实际的 WAR 包文件名
COPY target/word2.0-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# 4. 容器启动时，默认会运行 Tomcat，并监听 8080 端口
EXPOSE 8080
CMD ["catalina.sh", "run"]