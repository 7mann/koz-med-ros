basedir=$(dirname "$_")
basedir=$(cd "$basedir" && pwd)

jdk_version=15+36
jdk_version=11.0.8+10

jdk_major=${jdk_version%%+*}
jdk_major=${jdk_major%%.*}

url="https://github.com/AdoptOpenJDK/openjdk${jdk_major}-binaries/releases/download/jdk-${jdk_version}/OpenJDK${jdk_major}U-jdk_x64_linux_hotspot_${jdk_version/+/_}.tar.gz"
jdk_tar_gz="$(basename $url)"
export JAVA_HOME="$basedir/tools/jdk"

set -x
if [ ! -r "$basedir/tools/jdk-$jdk_version" ]
then
mkdir -p "$basedir/tools"

wget -O "jdk.tmp.tar.gz" "$url" && \
mv "jdk.tmp.tar.gz" "$basedir/tools/$jdk_tar_gz"
tar xf "$basedir/tools/$jdk_tar_gz" -C "$basedir/tools"
fi

if [ "$(readlink $JAVA_HOME)" != "jdk-$jdk_version" ]
then
echo "Changing JAVA_HOME to $jdk_version"
rm -f "$JAVA_HOME"
ln -s "jdk-$jdk_version" "$JAVA_HOME"
fi
PATH="$JAVA_HOME/bin:$PATH"

set +x