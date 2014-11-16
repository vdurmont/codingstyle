module.exports = {
    hashres: {
        options: {
            fileNameFormat: "${name}.${hash}.min.${ext}"
        },
        src: [
            "dist/assets/js/codingstyle.min.js",
            "dist/assets/css/codingstyle.min.css"
        ],
        dest: "dist/index.html"
    }
};
