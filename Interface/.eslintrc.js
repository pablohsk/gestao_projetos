module.exports = {
    root: true,
    env: {
        node: true,
    },
    extends: [
        'plugin:vue/essential',
        '@vue/standard',
    ],
    parserOptions: {
        parser: 'babel-eslint',
    },
    rules: {
        "space-before-function-paren": "off",
        "vue/multi-word-component-names": "off",
        "semi": "off",
        "eol-last": "off"
    },
};
