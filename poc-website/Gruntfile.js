module.exports = function (grunt) {
	grunt.initConfig({
		pkg: grunt.file.readJSON("package.json"),

		concat: {
			options: {
				separator: ";"
			},
			app_js: {
				src: ["src/js/**/*.js"],
				dest: "dist/tmp/<%= pkg.name %>.js"
			},
		},

		uglify: {
			options: {
				// the banner is inserted at the top of the output
				banner: "/*! <%= pkg.name %> <%= pkg.version %> [<%= grunt.template.today(\"dd-mm-yyyy\") %>] */\n",
				mangle: false
			},
			dist: {
				files: {
					"dist/js/<%= pkg.name %>.min.js": ["<%= concat.app_js.dest %>"]
				}
			}
		},

		copy: {
			production: {
				files: [
					{cwd: "src/", src: "index.html", expand: true, dest: "dist/", ext: ".html"},
					{cwd: "src", src: "img/**", expand: true, dest: "dist/"},
					{cwd: "src", src: "components/*", expand: true, dest: "dist/"},
					{cwd: "src", src: "partials/**", expand: true, dest: "dist/"},
					{cwd: "src", src: "lib/**", expand: true, dest: "dist/"},
					{cwd: "src", src: "css/**", expand: true, dest: "dist/"},
					{cwd: "src", src: "fonts/**", expand: true, dest: "dist/"}
				]
			}
		},

		less: {
			production: {
				options: {
					paths: ["assets/css"],
					yuicompress: true
				},
				files: {
					"dist/css/<%= pkg.name %>.min.css": "src/css/app.less"
				}
			}
		},

		jshint: {
			// define the files to lint
			files: ["src/js/**/*.js"],
			// configure JSHint (documented at http://www.jshint.com/docs/)
			options: {
				// more options here if you want to override JSHint defaults
				globals: {
					console: true,
					module: true,
					smarttabs: false,
					angular: false,
					strict: false,
				},
				eqnull: true
			}
		},

		hashres: {
			production: {
				src: ["dist/js/<%= pkg.name %>.min.js",
					"dist/css/<%= pkg.name %>.min.css"],
				dest: "dist/index.html"
			}
		},

		clean: {
			temp: {
				src: ["dist/tmp"]
			},
			all: {
				src: ["dist/**"]
			}
		}
	});

	grunt.loadNpmTasks("grunt-contrib-copy");
	grunt.loadNpmTasks("grunt-contrib-less");
	grunt.loadNpmTasks("grunt-contrib-jshint");
	grunt.loadNpmTasks("grunt-contrib-concat");
	grunt.loadNpmTasks("grunt-contrib-uglify");
	grunt.loadNpmTasks("grunt-hashres");
	grunt.loadNpmTasks("grunt-contrib-clean");

	grunt.registerTask("default", ["clean:all", "jshint", "concat", "uglify", "less", "copy", "hashres", "clean:temp"]);
};
