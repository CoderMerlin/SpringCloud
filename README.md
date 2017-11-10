# SpringCloud

#SVN  HTTP
<Location /svn>  
DAV svn  
#SVNPath /home/svn  
SVNParentPath /var/svn  
# # Limit write permission to list of valid users.  
# <LimitExcept GET PROPFIND OPTIONS REPORT>  
# # Require SSL connection for password protection.  
# # SSLRequireSSL  
#  
AuthType Basic  
AuthName "Authorization SVN"  
AuthzSVNAccessFile /var/svn/svntest/conf/authz  
AuthUserFile /var/svn/svntest/conf/svn_http_passwd  
Require valid-user  
# </LimitExcept>  
</Location>  

#!/bin/sh
# chkconfig: 2345 85 85
# processname: svn
svn_bin=/usr/local/svn/bin
svn_port=3690
svn_home=/home/svn
svn_config=/home/svn/conf/svnserve.conf
if [ ! -f "$svn_bin/svnserve" ]
then
echo "svnserver startup: cannot start"
exit
fi
case "$1" in
start)
echo "Starting svnserve..."
$svn_bin/svnserve -d -r $svn_home --config-file $svn_config --listen-port $svn_port
echo "Successfully!"
;;
stop)
echo "Stoping svnserve..."
killall svnserve
echo "Successfully!"
;;
restart)
$0 stop
$0 start
;;
*)
echo "Usage: svn { start | stop | restart } "
exit 1
esac


nginx
./configure \
--prefix=/usr/local/nginx \
--pid-path=/var/run/nginx/nginx.pid \
--lock-path=/var/lock/nginx.lock \
--error-log-path=/var/log/nginx/error.log \
--http-log-path=/var/log/nginx/access.log \
--with-http_gzip_static_module \
--http-client-body-temp-path=/var/temp/nginx/client \
--http-proxy-temp-path=/var/temp/nginx/proxy \
--http-fastcgi-temp-path=/var/temp/nginx/fastcgi \
--http-uwsgi-temp-path=/var/temp/nginx/uwsgi \
--http-scgi-temp-path=/var/temp/nginx/scgi
#!/bin/bash
REPOS="$1"
REV="$2"

#! /user/bin/ python
import urllib
import urllib2
test_data = {}
test_data_urlencode = urllib.urlencode(test_data)
requrl = "http://192.168.23.160:8041/bus/refresh"
req = urllib2.Request(url = requrl,data = test_data_urlencode)
print req
res_data = urllib2.urlopen(req)
res = res_data.read()
print res
