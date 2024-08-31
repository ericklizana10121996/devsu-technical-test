FROM oracleinanutshell/oracle-xe-11g

# Set the environment variable to allow remote connections
ENV ORACLE_ALLOW_REMOTE=true

# Expose the port that Oracle XE uses
EXPOSE 1521

RUN echo "CREATE USER devsu IDENTIFIED BY devsu;" | sqlplus /nolog

RUN echo "GRANT CONNECT, RESOURCE TO user;" | sqlplus /nolog




# Run the Oracle XE service
CMD ["/usr/bin/start_xe"]