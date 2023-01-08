FROM node:18.12.1-alpine
WORKDIR /usr/src/app
COPY package.json ./
COPY package-lock.json ./
RUN npm install --legacy-peer-deps
COPY . .
ENTRYPOINT ["npm","start"]