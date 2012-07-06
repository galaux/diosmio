#/bin/sh

THIS_NAME=$(basename $0)
THIS_VERSION=0.1

DIOSMIO_PREFIX='diosmio'

CMDLINE_JMXCLIENT_JAR=lib/cmdline-jmxclient-0.10.3.jar
DEFAULT_AUTH_STR='-'
USER=
PASS=
HOST=localhost
PORT=8090

usage() {
  echo "${THIS_NAME} v${THIS_VERSION} usage"
  echo -e "\t${THIS_NAME} -l service"
  echo -e "\t\tList operations available for this service"
  echo -e "\t${THIS_NAME} service operation [parameters]"
  echo -e "\t\tCall operation on the service with optional parameters"
}

issue_jmx() {
  java -jar ${CMDLINE_JMXCLIENT_JAR} '${USER}:${PASS}' ${HOST}:${PORT} $@
}

issue_jmx_command() {
  if [ $# -lt 2 ]; then
    echo -e 'Not enough arguments.\n'
    usage
    exit 1
  fi

  bean=$1
  operation=$2
  parameters=''
  if [ $# -gt 2 ]; then
    shift 2
    parameters=$1
    shift
    for p in $*; do
      parameters+=",$p"
    done
    parameters="=${parameters}"
  fi

  issue_jmx "bean:name=${bean} ${operation}${parameters}"
}

list_services() {
  issue_jmx | grep ${DIOSMIO_PREFIX}
}

list_operations() {
  bean=$1
  issue_jmx bean:name=${bean}
}

list() {
  if [ $# -eq 0 ]; then
    list_services
  elif [ $# -eq 1 ]; then
    list_operations $1
  else
    echo "Too many parameters"
  fi
}

auth_str="${USER}:${PASS}"
if [ -z ${USER} ]; then
  auth_str=${DEFAULT_AUTH_STR}
fi

case $1 in
  '-l')
    shift
    list $@
  ;;
  *)
    issue_jmx_command $@
  ;;
esac
