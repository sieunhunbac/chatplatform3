# Environment Variables Configuration

## Required Environment Variables for Render Deployment

```bash
# Database (Railway)
DATABASE_URL=jdbc:mysql://root:KQLWHqHJAgnWOLWVLXQurWUzLQmmzxtL@shinkansen.proxy.rlwy.net:15929/railway
DATABASE_USERNAME=root
DATABASE_PASSWORD=KQLWHqHJAgnWOLWVLXQurWUzLQmmzxtL

# JPA Configuration
JPA_DDL_AUTO=update
JPA_SHOW_SQL=false

# File Upload
MAX_FILE_SIZE=50MB
MAX_REQUEST_SIZE=50MB

# Server
PORT=8080

# JWT Security
JWT_SECRET=your-super-secret-jwt-key-change-this-in-production-min-256-bits
JWT_EXPIRATION=86400000

# Agora
AGORA_APP_ID=0230bbbb0b254599b2357e880af89d62
AGORA_APP_CERTIFICATE=your-agora-app-certificate-here

# CORS
CORS_ORIGINS=http://localhost:4200,http://localhost:8888,https://chat-platform-frontend.netlify.app

# Logging
LOG_LEVEL=INFO
```

## How to Set in Render

1. Go to your Render service dashboard
2. Navigate to "Environment" tab
3. Click "Add Environment Variable"
4. Copy-paste each variable above
5. Save and redeploy

## Local Development

For local development, you can set these in your IDE or create a `.env` file (not committed to git).
