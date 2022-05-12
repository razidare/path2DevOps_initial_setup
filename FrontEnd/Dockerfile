FROM node:16-slim AS builder
COPY . /builder/
WORKDIR /builder/angular-ui/
RUN export NODE_OPTIONS=--openssl-legacy-provider
RUN npm install
RUN npm uninstall node-sass
RUN npm install sass
RUN npm run build

#base image
FROM nginx:1.15.9
#select nginx configuration
ARG NGINXCONF=default.conf
COPY --from=builder /builder/angular-ui/dist /usr/share/nginx/html
COPY --from=builder /builder/nginx-conf/${NGINXCONF} /etc/nginx/conf.d/default.conf