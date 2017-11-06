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
