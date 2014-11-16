module.exports = {
    all: {
        options: {
            paths: ["src/app"],
            cleancss: true,
            yuicompress: true
        },
        files: {
            "dist/assets/css/codingstyle.min.css": "src/app/app.less"
        }
    }
};
