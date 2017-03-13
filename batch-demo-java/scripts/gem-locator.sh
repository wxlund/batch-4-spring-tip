if [ -z "$1" ]; then
    echo "Usage: gemfire-locator <locator-host>"
    exit 1
fi

## Locators to connect to distributed system
loc=$1[10334]

## Hostname to start locator with.
hn=`hostname`

## Standard Gemfire and Java args for both jvm tuning and stats
gfargs="--J=-Dgemfire.statistic-archive-file=$hn.gfs --J=-Dgemfire.archive-file-size-limit=100 --J=-Dgemfire.archive-disk-space-limit=1000  --J=-Dgemfire.http-service-port=7575"

gfsh start locator --name=loc-$hn --locators=$loc --initial-heap=1g --max-heap=1g $jvmargs $gfargs

## Optional config for Pdx Serialization 
#gfsh -e "connect" -e "configure pdx --read-serialized=true"