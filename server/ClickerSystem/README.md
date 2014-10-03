Install spring interface:
    Mac: $ brew tap pivotal/tap
         $ brew install springboot
         check: spring --version

Redirect your connection port 8080 as an example:

sudo ipfw add 100 fwd 127.0.0.1,9000 tcp from any to any 80 in