# We will use Ubuntu for our image
FROM ubuntu:latest

# Updating Ubuntu packages

ARG CLOJURE_TOOLS_VERSION=1.10.1.507


RUN apt-get -qq update && apt-get -qq -y install curl wget bzip2 openjdk-8-jdk-headless \
    && curl -o install-clojure https://download.clojure.org/install/linux-install-${CLOJURE_TOOLS_VERSION}.sh \
    && chmod +x install-clojure \
    && ./install-clojure && rm install-clojure \
    && wget https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein \
    && chmod a+x lein \
    && mv lein /usr/bin \
    && apt-get -qq -y autoremove \
    && apt-get autoclean \
    && rm -rf /var/lib/apt/lists/* /var/log/dpkg.log


ARG USERID
ARG GROUPID
ARG USERNAME

RUN groupadd -g $GROUPID $USERNAME
RUN useradd -u $USERID -g $GROUPID $USERNAME
RUN mkdir /home/$USERNAME && chown $USERNAME:$USERNAME /home/$USERNAME
USER $USERNAME

WORKDIR /home/$USERNAME

RUN wget https://julialang-s3.julialang.org/bin/linux/x64/1.5/julia-1.5.3-linux-x86_64.tar.gz \
  && tar -xvzf julia-1.5.3-linux-x86_64.tar.gz

ENV PATH /home/$USERNAME/julia-1.5.3/bin:$PATH
ENV JULIA_HOME /home/$USERNAME/julia-1.5.3
ENV LD_LIBRARY_PATH /home/$USERNAME/julia-1.5.3/lib
ENV JULIA_COPY_STACKS=yes

RUN lein -v