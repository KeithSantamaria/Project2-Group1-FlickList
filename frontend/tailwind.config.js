//https://tailwindcss.com/docs/configuration

const colors = require('tailwindcss/colors');

module.exports = {
  purge: [],
  darkMode: false, // or 'media' or 'class'
  theme: {
    extend: {},
    fontFamily: {
      'openSans': ['Open Sans'],
    },
    colors: {
      primary: '#1573ff',
      secondary: '#f85f5f',
      gray: colors.gray,
      white: colors.white,
      red: colors.red,
      green: colors.emerald,
      blue: colors.blue,
      indigo: colors.indigo
    }
  },
  variants: {
    extend: {},
  },
  plugins: [],
}
