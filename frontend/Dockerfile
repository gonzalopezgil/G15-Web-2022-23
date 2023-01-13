FROM node:18.12.1-alpine
WORKDIR /usr/src/app
COPY package.json ./
COPY package-lock.json ./
RUN npm install
COPY . .
ENTRYPOINT ["npm","start"]
