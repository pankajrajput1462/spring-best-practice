# Envoy

Exposing port is the important part of the container 

zipkin-tracing_front-envoy_1   /docker-entrypoint.sh /bin ...   Up      10000/tcp, 0.0.0.0:8000->80/tcp, 0.0.0.0:8001->8001/tcp
zipkin-tracing_service1_1      /bin/sh -c /usr/local/bin/ ...   Up      10000/tcp, 80/tcp                                      
zipkin-tracing_service2_1      /bin/sh -c /usr/local/bin/ ...   Up      10000/tcp, 80/tcp                                      
zipkin-tracing_zipkin_1        /busybox/sh run.sh               Up      9410/tcp, 0.0.0.0:9411->9411/tcp

In this:    
       exposed port is : 8000
 For accessing the URL for new service:       
    http://localhost:8000/trace/2