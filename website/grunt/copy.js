module.exports = [
    { cwd: "src", src: "index.html", expand: true, dest: "dist/" },
    { cwd: "src", src: "assets/**", expand: true, dest: "dist/" },
    { cwd: "src/app", src: "**/*.html", expand: true, dest: "dist/" }
];
