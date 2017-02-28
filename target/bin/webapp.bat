@REM ----------------------------------------------------------------------------
@REM Copyright 2001-2004 The Apache Software Foundation.
@REM
@REM Licensed under the Apache License, Version 2.0 (the "License");
@REM you may not use this file except in compliance with the License.
@REM You may obtain a copy of the License at
@REM
@REM      http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing, software
@REM distributed under the License is distributed on an "AS IS" BASIS,
@REM WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM See the License for the specific language governing permissions and
@REM limitations under the License.
@REM ----------------------------------------------------------------------------
@REM

@echo off

set ERROR_CODE=0

:init
@REM Decide how to startup depending on the version of windows

@REM -- Win98ME
if NOT "%OS%"=="Windows_NT" goto Win9xArg

@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" @setlocal

@REM -- 4NT shell
if "%eval[2+2]" == "4" goto 4NTArgs

@REM -- Regular WinNT shell
set CMD_LINE_ARGS=%*
goto WinNTGetScriptDir

@REM The 4NT Shell from jp software
:4NTArgs
set CMD_LINE_ARGS=%$
goto WinNTGetScriptDir

:Win9xArg
@REM Slurp the command line arguments.  This loop allows for an unlimited number
@REM of arguments (up to the command line limit, anyway).
set CMD_LINE_ARGS=
:Win9xApp
if %1a==a goto Win9xGetScriptDir
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto Win9xApp

:Win9xGetScriptDir
set SAVEDIR=%CD%
%0\
cd %0\..\.. 
set BASEDIR=%CD%
cd %SAVEDIR%
set SAVE_DIR=
goto repoSetup

:WinNTGetScriptDir
set BASEDIR=%~dp0\..

:repoSetup


if "%JAVACMD%"=="" set JAVACMD=java

if "%REPO%"=="" set REPO=%BASEDIR%\repo

set CLASSPATH="%BASEDIR%"\etc;"%REPO%"\org\apache\tomcat\embed\tomcat-embed-core\7.0.34\tomcat-embed-core-7.0.34.jar;"%REPO%"\org\apache\tomcat\embed\tomcat-embed-logging-juli\7.0.34\tomcat-embed-logging-juli-7.0.34.jar;"%REPO%"\org\apache\tomcat\embed\tomcat-embed-jasper\7.0.34\tomcat-embed-jasper-7.0.34.jar;"%REPO%"\org\eclipse\jdt\core\compiler\ecj\3.7.2\ecj-3.7.2.jar;"%REPO%"\org\apache\tomcat\tomcat-jasper\7.0.34\tomcat-jasper-7.0.34.jar;"%REPO%"\org\apache\tomcat\tomcat-servlet-api\7.0.34\tomcat-servlet-api-7.0.34.jar;"%REPO%"\org\apache\tomcat\tomcat-juli\7.0.34\tomcat-juli-7.0.34.jar;"%REPO%"\org\apache\tomcat\tomcat-el-api\7.0.34\tomcat-el-api-7.0.34.jar;"%REPO%"\org\apache\tomcat\tomcat-api\7.0.34\tomcat-api-7.0.34.jar;"%REPO%"\org\apache\tomcat\tomcat-util\7.0.34\tomcat-util-7.0.34.jar;"%REPO%"\org\apache\tomcat\tomcat-jasper-el\7.0.34\tomcat-jasper-el-7.0.34.jar;"%REPO%"\org\apache\tomcat\tomcat-jsp-api\7.0.34\tomcat-jsp-api-7.0.34.jar;"%REPO%"\com\thetransactioncompany\cors-filter\2.5\cors-filter-2.5.jar;"%REPO%"\com\thetransactioncompany\java-property-utils\1.9.1\java-property-utils-1.9.1.jar;"%REPO%"\com\sun\jersey\jersey-client\1.9.1\jersey-client-1.9.1.jar;"%REPO%"\com\sun\jersey\jersey-core\1.9.1\jersey-core-1.9.1.jar;"%REPO%"\org\springframework\spring-context\4.3.2.RELEASE\spring-context-4.3.2.RELEASE.jar;"%REPO%"\org\springframework\spring-aop\4.3.2.RELEASE\spring-aop-4.3.2.RELEASE.jar;"%REPO%"\org\springframework\spring-beans\4.3.2.RELEASE\spring-beans-4.3.2.RELEASE.jar;"%REPO%"\org\springframework\spring-core\4.3.2.RELEASE\spring-core-4.3.2.RELEASE.jar;"%REPO%"\commons-logging\commons-logging\1.2\commons-logging-1.2.jar;"%REPO%"\org\springframework\spring-expression\4.3.2.RELEASE\spring-expression-4.3.2.RELEASE.jar;"%REPO%"\org\springframework\spring-context-support\4.3.2.RELEASE\spring-context-support-4.3.2.RELEASE.jar;"%REPO%"\org\springframework\spring-webmvc\4.3.2.RELEASE\spring-webmvc-4.3.2.RELEASE.jar;"%REPO%"\org\springframework\spring-web\4.3.2.RELEASE\spring-web-4.3.2.RELEASE.jar;"%REPO%"\org\springframework\spring-orm\4.3.2.RELEASE\spring-orm-4.3.2.RELEASE.jar;"%REPO%"\org\springframework\spring-jdbc\4.3.2.RELEASE\spring-jdbc-4.3.2.RELEASE.jar;"%REPO%"\org\springframework\spring-tx\4.3.2.RELEASE\spring-tx-4.3.2.RELEASE.jar;"%REPO%"\org\springframework\security\spring-security-core\4.1.3.RELEASE\spring-security-core-4.1.3.RELEASE.jar;"%REPO%"\aopalliance\aopalliance\1.0\aopalliance-1.0.jar;"%REPO%"\org\springframework\security\spring-security-web\4.1.3.RELEASE\spring-security-web-4.1.3.RELEASE.jar;"%REPO%"\org\springframework\security\spring-security-config\4.1.3.RELEASE\spring-security-config-4.1.3.RELEASE.jar;"%REPO%"\org\springframework\security\spring-security-taglibs\4.1.3.RELEASE\spring-security-taglibs-4.1.3.RELEASE.jar;"%REPO%"\org\springframework\security\spring-security-acl\4.1.3.RELEASE\spring-security-acl-4.1.3.RELEASE.jar;"%REPO%"\org\hibernate\hibernate-core\4.2.0.Final\hibernate-core-4.2.0.Final.jar;"%REPO%"\antlr\antlr\2.7.7\antlr-2.7.7.jar;"%REPO%"\org\jboss\logging\jboss-logging\3.1.0.GA\jboss-logging-3.1.0.GA.jar;"%REPO%"\org\jboss\spec\javax\transaction\jboss-transaction-api_1.1_spec\1.0.0.Final\jboss-transaction-api_1.1_spec-1.0.0.Final.jar;"%REPO%"\dom4j\dom4j\1.6.1\dom4j-1.6.1.jar;"%REPO%"\org\hibernate\javax\persistence\hibernate-jpa-2.0-api\1.0.1.Final\hibernate-jpa-2.0-api-1.0.1.Final.jar;"%REPO%"\org\javassist\javassist\3.15.0-GA\javassist-3.15.0-GA.jar;"%REPO%"\org\hibernate\common\hibernate-commons-annotations\4.0.1.Final\hibernate-commons-annotations-4.0.1.Final.jar;"%REPO%"\javax\validation\validation-api\1.1.0.Final\validation-api-1.1.0.Final.jar;"%REPO%"\org\hibernate\hibernate-validator\5.0.1.Final\hibernate-validator-5.0.1.Final.jar;"%REPO%"\com\fasterxml\classmate\0.8.0\classmate-0.8.0.jar;"%REPO%"\c3p0\c3p0\0.9.1.2\c3p0-0.9.1.2.jar;"%REPO%"\javax\servlet\javax.servlet-api\3.1.0\javax.servlet-api-3.1.0.jar;"%REPO%"\jstl\jstl\1.2\jstl-1.2.jar;"%REPO%"\commons-dbcp\commons-dbcp\1.4\commons-dbcp-1.4.jar;"%REPO%"\commons-pool\commons-pool\1.5.4\commons-pool-1.5.4.jar;"%REPO%"\mysql\mysql-connector-java\5.1.25\mysql-connector-java-5.1.25.jar;"%REPO%"\org\slf4j\slf4j-api\1.7.1\slf4j-api-1.7.1.jar;"%REPO%"\com\eventmate\chat\0.0.1-SNAPSHOT\chat-0.0.1-SNAPSHOT.war
set EXTRA_JVM_ARGUMENTS=
goto endInit

@REM Reaching here means variables are defined and arguments have been captured
:endInit

%JAVACMD% %JAVA_OPTS% %EXTRA_JVM_ARGUMENTS% -classpath %CLASSPATH_PREFIX%;%CLASSPATH% -Dapp.name="webapp" -Dapp.repo="%REPO%" -Dbasedir="%BASEDIR%" com.eventmate.ChatModule.Main %CMD_LINE_ARGS%
if ERRORLEVEL 1 goto error
goto end

:error
if "%OS%"=="Windows_NT" @endlocal
set ERROR_CODE=1

:end
@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" goto endNT

@REM For old DOS remove the set variables from ENV - we assume they were not set
@REM before we started - at least we don't leave any baggage around
set CMD_LINE_ARGS=
goto postExec

:endNT
@endlocal

:postExec

if "%FORCE_EXIT_ON_ERROR%" == "on" (
  if %ERROR_CODE% NEQ 0 exit %ERROR_CODE%
)

exit /B %ERROR_CODE%
