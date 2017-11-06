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
